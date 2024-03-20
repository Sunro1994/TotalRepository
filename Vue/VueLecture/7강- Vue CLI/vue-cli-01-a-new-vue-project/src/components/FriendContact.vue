<template>
    <li>
        <h2>{{ name }}{{ isFavorites === false ? ' ' : '(favorites)' }}</h2>
        <button @click="toggleDetails">
            {{ detailsAreVisible ? 'Hide' : 'Show' }} Details

        </button>
        <button @click="toggleFavorites">
            {{ isFavorites === false ? 'remove' : 'add' }} Favorite</button>
        <ul v-if="detailsAreVisible">
            <li><strong>Phone: {{ phoneNumber }}</strong></li>
            <li><strong>Email: {{ emailAddress }}</strong></li>
        </ul>
        <button @click="$emit('delete',id)">Delete</button>

    </li>
</template>

<script>
export default {
    props: {
        id: {
            type: String,
            required: true
        },
        name: {
            type: String,
            required: true,
        },
        phoneNumber: {
            type: String,
            required: true,
        },
        emailAddress: {
            type: String,
            required: true
        },
        isFavorites: {
            type: Boolean,
            required: false,
            default: false,

        },


    },
    emits: {
        'toggle-favorite': function (id) {
            if (id) {
                return true;
            } else {
                console.warn('Id is missing!');
            } return false
        }
    },

    data() {
        return {
            detailsAreVisible: false,
            friend: {
                id: "manuel",
                name: "Manuel Lorenz",
                phone: "0123 456677 90",
                email: "manuel@localhost.com",
            },

        }
    },
    methods: {
        toggleDetails() {

            this.detailsAreVisible = !this.detailsAreVisible;
        },
        toggleFavorites() {
            this.$emit('toggle-favorite', this.id);
        }
    }
}
</script>